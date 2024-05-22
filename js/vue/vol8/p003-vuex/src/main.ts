import { createApp } from 'vue'
import { store } from './stores/counter'
import App from './App.vue'
const app = createApp(App)  // アプリ生成
app.use(store)              // Vuexの使用を指定
app.mount('#app')           // アプリをマウント（表示）
