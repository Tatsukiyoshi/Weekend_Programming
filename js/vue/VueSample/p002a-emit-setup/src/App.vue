<template>
  <div>
    <!-- PhoneWithBuyコンポーネントの描画 -->
    <div v-for="phone in phoneDataArray" v-bind:id="phone.name">
      <PhoneWithBuy :phoneData="phone" @onBuy="onBuyFromComponent"></PhoneWithBuy>
    </div>
  </div>
</template>
<script setup lang="ts">
// importするだけでコンポーネントが利用できる
import PhoneWithBuy from './components/PhoneWithBuy.vue'
import PhoneData from './PhoneData';
const phoneDataArray = [
  new PhoneData('Galaxy S22', 'Samsung', 125030),
  new PhoneData('AQUOS sense6', 'SHARP', 57024),
  new PhoneData('Xperia 1 IV', 'Sony', 192930),
  new PhoneData('arrows We', 'FCNT', 22000)
]
const onBuyFromComponent = ((phone: PhoneData) => {
  alert(`${phone.name}（${phone.dispPrice}円）を購入します。`)
})
</script>
