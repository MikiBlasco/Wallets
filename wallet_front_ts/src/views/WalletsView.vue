<template>
  <div class="wallets">

    <wallet-form-component></wallet-form-component>
    <wallet-component></wallet-component>
   
  </div>
</template>

<script lang="ts">
import { defineComponent} from "vue";
import WalletFormComponent from '../components/WalletFormComponent.vue'
import WalletComponent from '../components/WalletComponent.vue';



export default defineComponent({

  name: "WalletView",

  components: {
     WalletComponent,
     WalletFormComponent

  }

});
</script>

