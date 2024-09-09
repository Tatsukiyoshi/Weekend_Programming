import { defineConfig } from 'npm:vite@^5.4.0'
import vue from 'npm:@vitejs/plugin-vue@^5.1.3'

import 'npm:vue@^3.5.3'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue()]
})
