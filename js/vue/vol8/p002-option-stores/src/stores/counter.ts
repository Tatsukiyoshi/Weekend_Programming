import { defineStore } from 'pinia'
// ストアの定義
export const useCounterStore = defineStore('counter', {
  // ステート
  state() {
    return {
      count : 0
    }
  },
  // ゲッター
  getters: {
    doubleCount: (state) => state.count * 2
  },
  // アクション
  actions : {
    increment() {
      this.count++
    }
  }
})
