<template>
  <div class="elem-body">
    <div class="elem-name">{{ phoneData?.name }}</div>
    <div>
      【メーカー】{{ phoneData?.vendor }}
      【価格】{{ phoneData?.dispPrice }}円
    </div>
  </div>
</template>
<script lang="ts">
import { defineComponent } from "vue"
import PhoneData from "@/PhoneData" // PhoneDataクラスをインポート
export default defineComponent({
  props: {
    phoneData: PhoneData  // PhoneData型プロパティ
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