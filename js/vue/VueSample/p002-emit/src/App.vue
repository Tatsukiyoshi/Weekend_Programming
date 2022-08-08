<template>
  <div>
    <div v-for="phone in phoneDataArray" v-bind:id="phone.name">
      <PhoneWithBuy :phoneData="phone"
        @onBuy="onBuyFromComponent"><!-- onBuyイベントを設定 -->
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
      new PhoneData('AQUOS sense6', 'SHARP', 57024),
      new PhoneData('Xperia 1 IV', 'Sony', 192930),
      new PhoneData('arrows We', 'FCNT', 22000)
    ]
    // PhoneWithBuyコンポーネントのonBuyイベントハンドラー
    const onBuyFromComponent = ((phone: PhoneData) => {
      alert(`${phone.name}（${phone.dispPrice}円）を購入します。`)
    })
    return {
      phoneDataArray, onBuyFromComponent
    }
  }
})
</script>
