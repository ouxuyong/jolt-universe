package com.example.oxy.jolt;

import com.bazaarvoice.jolt.ContextualTransform;
import com.bazaarvoice.jolt.SpecDriven;
import com.bazaarvoice.jolt.common.Optional;
import com.bazaarvoice.jolt.common.tree.MatchedElement;
import com.bazaarvoice.jolt.common.tree.WalkedPath;
import com.bazaarvoice.jolt.exception.SpecException;
import com.bazaarvoice.jolt.modifier.OpMode;
import com.bazaarvoice.jolt.modifier.TemplatrSpecBuilder;
import com.bazaarvoice.jolt.modifier.function.Function;
import com.bazaarvoice.jolt.modifier.spec.ModifierCompositeSpec;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author oxy
 * @date 2022/05/28
 */
@SuppressWarnings({"unchecked", "deprecation"})
public class JoltCustomizedModifier implements SpecDriven, ContextualTransform {
    private static final Map<String, Function> STOCK_FUNCTIONS = new HashMap<>();

    private final ModifierCompositeSpec rootSpec;

    static {
        STOCK_FUNCTIONS.put("recursiveReplacement", new JoltCustomizedFunction.RecursiveReplacementFunc());
        STOCK_FUNCTIONS.put("recursiveOperation", new JoltCustomizedFunction.RecursiveOperationFunc());
    }

    private JoltCustomizedModifier(Object spec, OpMode opMode, Map<String, Function> functionsMap) {
        if (spec == null) {
            throw new SpecException(opMode.name() + " expected a spec of Map type, got 'null'.");
        }

        if (!(spec instanceof Map)) {
            throw new SpecException(opMode.name() + " expected a spec of Map type, got " + spec.getClass().getSimpleName());
        }

        if (functionsMap == null || functionsMap.isEmpty()) {
            throw new SpecException(opMode.name() + " expected a populated functions' map type, got " + (functionsMap == null ? "null" : "empty"));
        }

        functionsMap = Collections.unmodifiableMap(functionsMap);
        TemplatrSpecBuilder templatrSpecBuilder = new TemplatrSpecBuilder(opMode, functionsMap);

        rootSpec = new ModifierCompositeSpec(ROOT_KEY, (Map<String, Object>) spec, opMode, templatrSpecBuilder);
    }

    @Override
    public Object transform(Object input, Map<String, Object> context) {
        Map<String, Object> contextWrapper = new HashMap<>();
        contextWrapper.put(ROOT_KEY, context);

        MatchedElement rootLpe = new MatchedElement(ROOT_KEY);
        WalkedPath walkedPath = new WalkedPath();
        walkedPath.add(input, rootLpe);

        rootSpec.apply(ROOT_KEY, Optional.of(input), walkedPath, null, contextWrapper);
        return input;
    }

    public static final class Overwrite extends JoltCustomizedModifier {

        public Overwrite(Object spec) {
            this(spec, STOCK_FUNCTIONS);
        }

        public Overwrite(Object spec, Map<String, Function> functionsMap) {
            super(spec, OpMode.OVERWRITR, functionsMap);
        }
    }

}