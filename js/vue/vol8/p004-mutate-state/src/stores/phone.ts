import { ref, computed } from 'vue'
import { defineStore } from 'pinia'

// ストアの定義
export const usePhoneStore = defineStore('phone', () => {
  // ステート
  const name = ref('iPhone 15 Pro')
  const vendor = ref('Apple')
  const price = ref(159800)
  const features = ref(['5G', 'チタニウム', 'アクションボタン'])

  // ゲッター
  const formattedPrice = computed(() => {
    const formatter = new Intl.NumberFormat('ja-JP')
    return formatter.format(price.value)
  })

  // 返却
  return { name, vendor, price, features, formattedPrice }
})
