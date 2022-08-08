<script lang="ts">
import { defineComponent } from "vue"
import PhoneData from "../PhoneData" // PhoneDataクラスをインポート ...（1）
export default defineComponent({
  props: {
    phoneData: PhoneData  // PhoneData型プロパティ ...（2）
  }
})
</script>
