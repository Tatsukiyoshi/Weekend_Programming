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

  // 引数付きゲッター
  const formattedPriceWithUnit = computed(() => {
    return (unit:string) => `${unit}${formattedPrice.value}`
  })

  // 非同期アクション
  async function fetchDataAsync() {
    // phone.jsonを取得
    var result = await fetch('/phone.json').then(res => res.json())
    // ステートを更新
    name.value = result.name
    vendor.value = result.vendor
    price.value = result.price
    features.value = result.features
  }

  // 返却
  return { name, vendor, price, features, formattedPrice, formattedPriceWithUnit, fetchDataAsync }
})
