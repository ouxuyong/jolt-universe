# Cases related to the use of different modes
The expression of jolt is a list, so we can combine multiple patterns when we use it   
1. [Simple combination use](#a1)  
2. [Examples of other developers on the jolt official website asking for help](#a2)  
- 2.1[Merge arrays and use parent key as attribute](#a2_1)  
- 2.2[How to transform the single json to json arrays？](#a2_2)  
- 2.3[Match value from another field value](#a2_3)  
- 2.4[JOLT spec for removing/skipping a JSON element based on existence of another element](#a2_4)  
- 2.5[How to convert multiple array](#a2_5)  
- 2.6[Make flat json array from nested one via jolt](#a2_6)  

## <a name="a1"></a> Simple combination use
input :
```json
{
  "rating": {
    "primary": {
      "value": 3
    },
    "quality": {
      "value": 3
    }
  }
}
   
 ```  
 spec：
  ```json
 [
   {
     "operation": "shift",
     "spec": {
       "rating": {
         "primary": {
           // simple match.  Put the value '4' in the output under the "Rating" field
           "value": "Rating",
           "max": "RatingRange"
         },
         // match any children of "rating"
         // Shiftr has a precendence order when matching, so the "*" will match "last".
         // In this case anything that isn't "primary".
         "*": {
           // &1 means, go up one level and grab that value and substitute it in
           //  in this example &1 = "quality"
           "max":   "SecondaryRatings.&1.Range",
           "value": "SecondaryRatings.&1.Value",
           //
           // We want "quality" to be a value field in the output under
           //  "SecondaryRatings.quality.Id", but "quality" is an input key not an input value.
           // The "$" operator means use the input key, instead of the input value as ouput
           "$": "SecondaryRatings.&1.Id"
         }
       }
     }
   },
   {
     "operation": "default",
     "spec": {
       "Range": 5,
       "SecondaryRatings": {
         "*": {
           // Defaut all "SecondaryRatings" to have a Range of 5
           "Range": 5
         }
       }
     }
   }
 ]

 ```  
 expected ：
   ```json
{
  "Rating" : 3,
  "SecondaryRatings" : {
    "quality" : {
      "Id" : "quality",
      "Value" : 3,
      "Range" : 5
    }
  },
  "Range" : 5
}
  ```  
   ## <a name="a2"></a> Examples of other developers on the jolt official website asking for help
  #### <a name="a2_1"></a> Merge arrays and use parent key as attribute
[Merge arrays and use parent key as attribute](https://github.com/bazaarvoice/jolt/issues/1106).  
input: 
  ```json
  {
	"userData": {
		"entities": [{
				"username": "test1",
				"address": "exampleAddress"
			},
			{
				"username": "test2",
				"address": "exampleAddress2"
			}
		]
	},
	"programData": {
		"entities": [{
				"crashed?": "no",
				"time ran?": "N/A"
			},
			{
				"crashed?": "yes",
				"time ran?": "5 min"
			}
		]
	}
}
  ```  
 
 expected:  
 ```json
 [ {
  "username" : "test1",
  "address" : "exampleAddress",
  "parent" : "userData"
}, {
  "username" : "test2",
  "address" : "exampleAddress2",
  "parent" : "userData"
}, {
  "crashed?" : "no",
  "time ran?" : "N/A",
  "parent" : "programData"
}, {
  "crashed?" : "yes",
  "time ran?" : "5 min",
  "parent" : "programData"
} ]
 ```  
 solve the answer spec:
 ```json
 [
  {
    "operation": "modify-overwrite-beta",
    "spec": {
      "userData": {
        "entities": {
          "*": {
            "parent": "userData"
          }
        }
      },
      "programData": {
        "entities": {
          "*": {
            "parent": "programData"
          }
        }
      }
    }
    },
  {
    "operation": "shift",
    "spec": {
      "*": {
        "entities": {
          "*": {
            "@": "[]"
          }
        }
      }
    }
    }
]

 ```  
 #### <a name="a2_2"></a>How to transform the single json to json arrays？
[How to transform the single json to json arrays](https://github.com/bazaarvoice/jolt/issues/1107).  
input:  
  ```json
  {
  "ID": "123456789",
  "METER_ID": "987654312",
  "DATA_DATE": "2021-11-01 00:00:00",
  "FLAG": "2",
  "I1": 1,
  "I2": 2,
  "I3": 3,
  "I4": 4,
  "I5": 5
}
  ```  
 
 expected:  
 ```json
 [ {
  "ID" : "123456789",
  "METER_ID" : "987654312",
  "DATA_DATE" : "2021-11-01 00:00:00",
  "FLAG" : "2",
  "DATA" : 1
}, {
  "ID" : "123456789",
  "METER_ID" : "987654312",
  "DATA_DATE" : "2021-11-01 00:00:00",
  "FLAG" : "2",
  "DATA" : 2
}, {
  "ID" : "123456789",
  "METER_ID" : "987654312",
  "DATA_DATE" : "2021-11-01 00:00:00",
  "FLAG" : "2",
  "DATA" : 3
}, {
  "ID" : "123456789",
  "METER_ID" : "987654312",
  "DATA_DATE" : "2021-11-01 00:00:00",
  "FLAG" : "2",
  "DATA" : 4
}, {
  "ID" : "123456789",
  "METER_ID" : "987654312",
  "DATA_DATE" : "2021-11-01 00:00:00",
  "FLAG" : "2",
  "DATA" : 5
} ]
 ```  
 solve the answer spec:
 ```json
[
  {
    "operation": "shift",
    "spec": {
      "ID": "data.ID",
      "*": {
        "@": "data.&1"
      },
      "I*": {
        "@": "DATA"
      }
    }
  }, {
    "operation": "shift",
    "spec": {
      "DATA": {
        "*": {
          "@2": {
            "data": {
              "*": {
                "@": "[#5].&1"
              }
            }
          },
          "@": "[#2].&2"
        }
      }
    }
  }
]


 ```  
###  <a name="a2_3"></a>Match value from another field value 
[Match value from another field value](https://github.com/bazaarvoice/jolt/issues/1123).  
 input: 
  ```json
{
  "request": {
    "requestID": "1"
  },
  "items": [
    {
      "ID": "1",
      "name": "item1"
    },
    {
      "ID": "2",
      "name": "item2"
    }
  ]
}
  ```  
 
  expected:  
 ```json
{
  "matchedItem" : {
    "ID" : "1",
    "name" : "item1"
  }
}
 ```  
 solve the answer spec:
 ```json
[{
  "operation": "shift",
  "spec": {
    "items": {
      "0": {
        "ID": "matchedItem.ID",
        "name": "matchedItem.name"
      }
    }
  }
}]

 ```  
 #### <a name="a2_4"></a>JOLT spec for removing/skipping a JSON element based on existence of another element
[JOLT spec for removing/skipping a JSON element based on existence of another element](https://github.com/bazaarvoice/jolt/issues/1128).  
 input: 
  ```json
{
	"client": {
		"mailingDetails": {
			"permanentAddress": {
				"house": "04576",
				"street": "Wilson Street",
				"addressId": "7w34df"
			},
			"citizenship": {
				"country": "USA"
			}
		}
	}
}
  ```  
 
 expected:  
 ```json
{
  "client" : {
    "mailingDetails" : {
      "permanentAddress" : {
        "house" : "04576",
        "street" : "Wilson Street",
        "addressId" : "7w34df"
      },
      "citizenship" : {
        "country" : "USA"
      }
    }
  }
}
 ```  
 solve the answer spec:
 ```json
[{
    "operation": "modify-overwrite-beta",
    "spec": {
      "client": {
        "mailingDetails": {
          "currentAddress": {
            "house": "0001",
            "street": "Default Street",
            "addressId": "DefaultID"
          },
          "temp": ["currentAddress"]
        }
      }
    }
	},
  {
    "operation": "shift",
    "spec": {
      "client": {
        "mailingDetails": {
          "permanentAddress": {
            "@1": {
              "#permanentAddress": "client.mailingDetails.temp"
            },
            "*": "client.mailingDetails.permanentAddress.&"
          },
          "temp": {
            "@": "client.mailingDetails.temp.[#2]"
          },
          "currentAddress": "client.mailingDetails.currentAddressTemp.&",
          "citizenship": {
            "*": "client.mailingDetails.citizenship.&"
          }
        }
      }
    }
	}, {
    "operation": "shift",
    "spec": {
      "client": {
        "mailingDetails": {
          "permanentAddress": "client.mailingDetails.permanentAddress",
          "temp": {
            "0": {
              "currentAddress": {
                "@3": {
                  "currentAddressTemp": {
                    "*": "client.mailingDetails.&"
                  }
                }
              }
            }
          },
          "citizenship": {
            "*": "client.mailingDetails.citizenship.&"
          }
        }
      }
    }
	}
]

 ```  
 ####  <a name="a2_5"></a>How to convert multiple array
 [How to convert multiple array](https://github.com/bazaarvoice/jolt/issues/1130).  
 input: 
  ```json
{
  "field1": [
    {
      "test1": "1",
      "test2": "2"
    },
    {
      "test1": "3",
      "test2": "4"
    }
  ],
  "field2": [
    {
      "test3": "5",
      "test4": "6"
    },
    {
      "test3": "7",
      "test4": "8"
    }
  ],
  "field3": [
    {
      "test5": "9",
      "test6": "10"
    },
    {
      "test5": "11",
      "test6": "12"
    }
  ],
  "field4": [
    {
      "test7": "13",
      "test8": "14"
    },
    {
      "test7": "15",
      "test8": "16"
    }
  ]
}
  ```  
 
  expected:  
 ```json
[
  {
    "field1_test1": "1",
    "field1_test2": "2",
    "field2_test3": "5",
    "field2_test4": "6",
    "field3_test5": "9",
    "field3_test6": "10",
    "field4_test7": "13",
    "field4_test8": "14"
  },  {
  "field1_test1": "3",
  "field1_test2": "4",
  "field2_test3": "7",
  "field2_test4": "8",
  "field3_test5": "11",
  "field3_test6": "12",
  "field4_test7": "15",
  "field4_test8": "16"
}
]
 ```  
 solve the answer spec:
 ```json
[
  {
    "operation": "shift",
    "spec": {
      "*": {
        "0": {
          "*": "[#2].&2_&0"
        },
        "1": {
          "*": "[#2].&2_&0"
        }
      }
    }
  }
]

 ```  
  ####  <a name="a2_6"></a>Make flat json array from nested one via jolt
 [Make flat json array from nested one via jolt](https://github.com/bazaarvoice/jolt/issues/1139).  
 input: 
  ```json
{
  "MainArray": {
    "mattr1": "some_value1",
    "mattr2": "some_value2",
    "Subarray": {
         "sattr1": 1,
         "sattr2": 2,
         "sattr3": 3
    }
  }
}
  ```  
 
  expected:  
 ```json
{
	"ResultArray": [
		["mattr1", "some_value1"],
		["mattr2", "some_value2"],
		["sattr1", 1],
		["sattr2", 2],
		["sattr1", 3]
	]
}
 ```  
 solve the answer spec:
 ```json
[
  {
    "operation": "shift",
    "spec": {
      "MainArray": {
        "*": {
          "$": "ResultArrayTemp0[#2]",
          "@": "ResultArrayTemp0[#2]"
        },
        "Subarray": {
          "*": {
            "$": "ResultArrayTemp1[#2]",
            "@": "ResultArrayTemp1[#2]"
          }
        }
      }
    }
  }, {
    "operation": "shift",
    "spec": {
      "ResultArrayTemp0": {
        "*": "ResultArray[]"
      },
      "ResultArrayTemp1": {
        "*": "ResultArray[]"
      }
    }
  }
]

 ```  


