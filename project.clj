(defproject sicp-mailonline "0.1.0-SNAPSHOT"
  :description "Code and exercises for SICP implemented in Clojure"
  :url "https://github.com/rachbowyer/sicp-mailonline"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :resource-paths ["shared" "resources"]          
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [rachbowyer/henderson "0.1.0"]]
  :jvm-opts ["-Xmx8096M"])
