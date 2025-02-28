Examples to show that Specmatic does not detect changes in included files that do not have 'openapi' element.

### changes in included file that does not have 'openapi' element

* make breaking change in "includedSimple.yaml" (for example rename "data" to something else)
* start specmatic backward compatibility check: ``java -jar specmatic.jar backward-compatibility-check``
* Specmatic will NOT see any changes in OpenApi:

```
Specmatic Version: 2.6.0
 No specs were changed, skipping the check.
```

* make some change in "root.yaml" (for example add space somewhere)
* start specmatic backward compatibility check: ``java -jar specmatic.jar backward-compatibility-check``
* Specmatic will see changes in OpenApi:

```
Specmatic Version: 2.6.0
Checking backward compatibility of the following specs:
  - Specs that have changed:
    1. D:\my\SpecmaticBackwardCompatibilityCheck\.\root.yaml

  - Specs referring to the changed specs:
    1. .\includedAsOpenApiDocument.yaml
    2. .\root.yaml
...
```

_Note_: Here can you see that "includedSimple.yaml" is not listed in the output, but "includedAsOpenApiDocument.yaml" is listed, even it is not changed.

### changes in included file that have 'openapi' element

* make breaking change in "includedAsOpenApiDocument.yaml" (for example rename "data" to something else)
* start specmatic backward compatibility check: ``java -jar specmatic.jar backward-compatibility-check``
* Specmatic will see changes in OpenApi:

```
Specmatic Version: 2.6.0
Checking backward compatibility of the following specs:
  - Specs that have changed:
    1. D:\my\SpecmaticBackwardCompatibilityCheck\.\includedAsOpenApiDocument.yaml
  - Specs referring to the changed specs:
    1. .\root.yaml
    2. .\includedAsOpenApiDocument.yaml
...
```

