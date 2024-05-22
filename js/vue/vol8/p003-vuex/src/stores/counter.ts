import { createStore } from 'vuex'
// ストアの定義
export const store = createStore({
  // ステート
  state () {
    return {
      count: 0
    }
  },
  // ゲッター
  getters: {
    doubleCount: (state) => state.count * 2
  },
  // ミューテーション
  mutations: {
    increment (state) {
      state.count++
    }
  },
  // アクション
  actions: {
    increment (context) {
      context.commit('increment')
    }
  }
})
