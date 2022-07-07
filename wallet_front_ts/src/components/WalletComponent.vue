<template>
  <div>
    <div v-if="!isLoading">
      {{ user.name }} wallets
      <button v-on:click="showWalletDetails()">details</button>
      <div v-for="wallet in user.walletList" :key="wallet.id">
        <ul class="wallet">
          {{
            wallet.currency_name
          }}
          Wallet

          <ul v-if="showWallet">
            <li>
              Amount: {{ wallet.currency_amount }} {{ wallet.currency_name }}
            </li>
            <li>Value USD: ???</li>
          </ul>
        </ul>
      </div>
    </div>
    <div v-else></div>
  </div>
</template>

<script lang="ts">
import { UserService } from "@/services/UserService";
import { defineComponent, onMounted, ref } from "vue";
import { useRoute } from "vue-router";

export default defineComponent({
  name: "WalletComponent",

    methods: {
  showWalletDetails() {
      console.log("button");
      if (this.showWallet) this.showWallet = false
      else this.showWallet = true
   }
   },

  setup() {
    const service = new UserService();
    const user = service.getUser();
    const isLoading = ref<boolean>(true);
    const showWallet = ref<boolean>(false);
    const { id } = useRoute().params;
    // const addWallet = () => {
    //   console.log("add Wallet");
    // };

    onMounted(async () => {
      await service.fetchById(id);
      isLoading.value = false;
      showWallet.value = false;
    });

    return {
      user,
      isLoading,
      showWallet,
      // addWallet
    }
  },
});
</script>

<style></style>
