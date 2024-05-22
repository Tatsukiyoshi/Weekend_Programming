import { createApp } from 'vue'
import { createPinia } from 'pinia'
import App from './App.vue'
const app = createApp(App)  // アプリ生成
app.use(createPinia())      // Piniaの使用を指定
app.mount('#app')           // アプリをマウント（表示）
