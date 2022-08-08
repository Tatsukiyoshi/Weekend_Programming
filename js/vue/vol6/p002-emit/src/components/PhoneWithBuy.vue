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
import { defineComponent } from 'vue';
import PhoneData from '../PhoneData'
export default defineComponent({
    props:{
        phoneData: PhoneData
    },
    emits: [
        'onBuy' // emitする可能性があるイベントを指定 ...（1）
    ],
    setup(props, context) { // setupの引数でpropsとcontextを受け取る ...（2）
        // 購入するボタンクリック時の処理
        const onClickBuyButton = (() => {
        context.emit('onBuy', props.phoneData) // onBuyイベントをemit ...（3）
        })
        return { onClickBuyButton }
    }
})
</script>
