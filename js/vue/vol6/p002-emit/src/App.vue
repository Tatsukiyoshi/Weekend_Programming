<template>
  <div>
    <div v-for="phone in phoneDataArray" v-bind:key="phone.name">
      <PhoneWithBuy :phoneData="phone"
        @onBuy="onBuyFromComponent"><!-- onBuyイベントを設定 ...（1）-->
      </PhoneWithBuy>
    </div>
  </div>
</template>
<script lang="ts">
import { defineComponent } from 'vue'
import PhoneWithBuy from './components/PhoneWithBuy.vue'
import PhoneData from './PhoneData'
export default defineComponent({
  components: {
    PhoneWithBuy
  },
  setup() {
    const phoneDataArray = [
      new PhoneData('Galaxy S22', 'Samsung', 125030),
      new PhoneData('arrows We', 'FCNT', 22000)
    ]
    // PhoneWithBuyコンポーネントのonBuyイベントハンドラー ...（2）
    const onBuyFromComponent = ((phone: PhoneData) => {
      alert(`${phone.name}（${phone.dispPrice}円）を購入します。`)
    })
    return {
      phoneDataArray, onBuyFromComponent
    }
  }
})
</script>
