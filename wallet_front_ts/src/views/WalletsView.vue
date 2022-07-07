<template>
  <div class="wallets">
    <div class="walletForm">
      <wallet-form-component></wallet-form-component>
    </div>
    <div class="userWallets">
      <wallet-component></wallet-component>
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import WalletFormComponent from "../components/WalletFormComponent.vue";
import WalletComponent from "../components/WalletComponent.vue";

export default defineComponent({
  name: "WalletView",

  components: {
    WalletComponent,
    WalletFormComponent,
  },
});
</script>

<style>
.wallets {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  margin: 10px;
  width: 400px;
}



.userWallets{
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  border: 1px rgb(245, 234, 234) solid;
  border-radius: 8px;
  margin: 5px;
  padding: 10px;
}

.walletForm {
  border: 1px grey solid;
  border-radius: 8px;
  padding: 10px;
  margin: 5px;

}

.walletCard{
  width: 250px;
}
</style>
