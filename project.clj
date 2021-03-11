(defproject sicp-clojure "0.1.0-SNAPSHOT"
  :description "Code and exercises for SICP implemented in Clojure"

  :url "https://github.com/rachbowyer/sicp-clojure"

  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :resource-paths ["shared" "resources"]

  :dependencies [[org.clojure/clojure "1.10.1"]
                 [rachbowyer/henderson "0.1.0"]
                 [rachbowyer/keirin "1.1.1"]]

  :main sicp-clojure.core

  :profiles {:dev {:global-vars {*warn-on-reflection* false *assert* true}
                   :jvm-opts ^:replace ["-Dclojure.compiler.direct-linking=true" "-server"
                                        "-Xlog:gc:gc.out" "-XX:-TieredCompilation" "-Xbatch"]}

             :uberjar {:jvm-opts ^:replace ["-Dclojure.compiler.direct-linking=true"]
                       :aot :all}})
