<template>
  <div class="wallets">
    <div v-if="!isLoading">
      <div v-for="wallet in user.walletList" :key="wallet.id">
        <ul class="wallet">
          {{
            wallet.currency_name
          }}
          Wallet:
          <li>
            Amount: {{ wallet.currency_amount }} {{ wallet.currency_name }}
          </li>
          <li>Value USD: ???</li>
        </ul>
      </div>
    </div>
    <div v-else></div>
  </div>
</template>

<script lang="ts">
import { defineComponent, onMounted, ref } from "vue";
import { useRoute } from "vue-router";
import { UserService } from "../services/UserService";

export default defineComponent({
  name: "wallet",

  setup() {
    const service = new UserService();
    const user = service.getUser();
    const isLoading = ref<boolean>(true);
    const { id } = useRoute().params;
    console.log(useRoute().params);

    onMounted(async () => {
      await service.fetchById(id);
      isLoading.value = false;
    });

    return {
      user,
      isLoading,
    };
  },
});
</script>
