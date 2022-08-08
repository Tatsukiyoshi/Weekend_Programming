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
  props: { // プロパティ
    vendor: String,   // 文字列型
    name: String,     // 文字列型
    price: {  // より細かい指定を行う例
      type: Number,   // 数字型
      default: 0,     // 初期値0
      required: true  // 必須
    }
  }
})
</script>
<style scoped>
.elem-body {
  margin-top: 5px;
  padding: 5px;
  border: solid black 1px;
  background-color: lightpink;
  color: black;
  font-size: 12pt;
}

.elem-name {
  font-size: 18pt;
}
</style>