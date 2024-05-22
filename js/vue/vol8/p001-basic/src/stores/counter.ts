import { ref, computed } from 'vue'
import { defineStore } from 'pinia'

// ストアの定義
export const useCounterStore = defineStore('counter', () => {
  const count = ref(0)    // ステート
  const doubleCount = computed(() => count.value * 2)   // ゲッター

  // アクション
  function increment() {
    count.value++
  }

  // 定義したステート、ゲッター、アクションを返却
  return { count, doubleCount, increment }
})
