<template>
  <div class="elem-body">
    <div class="elem-name">{{ phoneData?.name }}</div>
    <div>
      【メーカー】{{ phoneData?.vendor }}
      【価格】{{ phoneData?.dispPrice }}円
    </div>
    <div>
      <button @click="onClickBuyButton">購入する</button>
    </div>
  </div>
</template>
<script setup lang="ts">
import PhoneData from '../PhoneData';
const props = defineProps({
  phoneData: PhoneData  // PhoneData型プロパティ
})
const emit = defineEmits([
  'onBuy' // emitする可能性があるイベントを指定
])
const onClickBuyButton = (() => {
  emit('onBuy', props.phoneData)
})
</script>
<style scoped>
.elem-body {
  margin-top: 5px;
  padding: 5px;
  border: solid black 1px;
  background-color: lightblue;
  color: black;
  font-size: 12pt;
}

.elem-name {
  font-size: 18pt;
}
</style>