import { defineConfig } from 'unocss'

export default defineConfig({
  cli: {
    entry: {
        patterns: ["src/opus_classical_clojure/views/**/*.clj"],
        outFile: "resources/public/styles.css"
    },
  },
})