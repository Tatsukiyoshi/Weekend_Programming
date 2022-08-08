<template>
  <CustomError>
    名前なしスロットに渡されます。
    <template v-slot:desc>
      名前付きスロットに渡されます。
    </template>
  </CustomError>
</template>
<script lang="ts">
import { defineComponent } from 'vue'
import CustomError from './components/CustomError.vue'
export default defineComponent({
  components: {
    CustomError
  }
})
</script>
