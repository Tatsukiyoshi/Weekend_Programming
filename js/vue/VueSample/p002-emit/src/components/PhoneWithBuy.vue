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
<script lang="ts">
import { defineComponent } from 'vue'
import PhoneData from '@/PhoneData'
export default defineComponent({
  props: {
    phoneData: PhoneData  // PhoneData型プロパティ
  },
  emits: [
    'onBuy' // emitする可能性があるイベントを指定
  ],
  setup(props, context) { // setupの引数でpropsとcontextを受け取る
    // 購入するボタンクリック時の処理
    const onClickBuyButton = (() => {
      context.emit('onBuy', props.phoneData) // onBuyイベントをemit
    })
    return { onClickBuyButton }
  }
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