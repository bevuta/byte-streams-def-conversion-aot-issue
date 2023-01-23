# Minimal repro of clj-commons/byte-streams aot issue

Similar to https://github.com/clj-commons/byte-streams/issues/34 but with `tools.deps` and `tools.build` instead. Run:

    clojure -T:build uberjar

Error:

    Execution error (ClassCastException) at clj_commons.byte_streams.graph.ConversionGraph/assoc_conversion (graph.clj:117).
    class clj_commons.byte_streams.graph.Type cannot be cast to class clj_commons.byte_streams.graph.Type (clj_commons.byte_streams.graph.Type is in unnamed module of loader 'app'; clj_commons.byte_streams.graph.Type is in unnamed module of loader clojure.lang.DynamicClassLoader @650a1aff)


Commenting out the `:ns-compile '[foo bar]` in `build.clj` will make it work.


Likely cause: https://clojure.atlassian.net/browse/CLJ-1741
