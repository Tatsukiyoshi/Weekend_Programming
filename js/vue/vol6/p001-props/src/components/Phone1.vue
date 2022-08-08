<template>
  <div class="elem-body">
    <div class="elem-name">{{ name }}</div>
    <div>
      【メーカー】{{ vendor }}
      【価格】{{ Intl.NumberFormat('ja-JP').format(price) }}円
    </div>
  </div>
</template>
<script lang="ts">
import { defineComponent } from 'vue'
export default defineComponent({
  props: { // プロパティ ...（2）
    vendor: String,   // 文字列型 ...（2a）
    name: String,     // 文字列型
    price: {  // より細かい指定を行う例 ...（2b）
      type: Number,   // 数字型
      default: 0,     // 初期値0
      required: true  // 必須
    }
  }
})
</script>
