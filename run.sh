#!/usr/bin/env bash

java -Dclojure.compiler.direct-linking=true -server -Xlog:gc:gc.out \
     -XX:-TieredCompilation -Xbatch \
     -Xms4g -Xmx4g \
     -jar target/sicp-clojure-0.1.0-SNAPSHOT-standalone.jar