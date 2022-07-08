<template>

  <div>
    <div v-if="!isLoading">
      {{ user.name }} wallets

      <div
        class="walletCard"
        v-for="(wallet, index) in user.walletList"
        :key="wallet.id"
      >
      
        <ul class="wallet">
          <div style="font-weight: bold">
            {{ wallet.currency_name }}

            <button class="button2" v-on:click="showWalletDetails(index)">
              Details
            </button>
          </div>

          <ul v-if="showWallet[index]">
            <li>
              Amount: {{ wallet.currency_amount }} {{ wallet.currency_name }}
              <button class="button3" v-on:click="showEdit(index)"> Edit </button>
              <div v-if="showEditor[index]">
                <input style="width:50px; font-size:10px;"  type="number" v-model="amount" placeholder="new amount"> 
                <button class="button3" v-on:click="editAmount(amount, wallet)" style="background-color: black; color:white">save</button>


              </div>
              
              
            </li>
            <li>Value USD: {{ info.data?.BTC?.quote?.USD?.price }}</li>

            <button class="button1" v-on:click="deleteWallet(wallet)">
              Delete
            </button>
            
          </ul>
        </ul>
      </div>
    </div>
    <div v-else></div>
  </div>
</template>

<script lang="ts">
import { UserService } from "@/services/UserService";
import { WalletService } from "@/services/WalletService";
import { defineComponent, onMounted, ref } from "vue";
import { useRoute } from "vue-router";
import WalletCardComponent from "./components/WalletCardComponent.vue"
import WalletFormComponent from "./WalletFormComponent.vue";

export default defineComponent({
    name: "WalletComponent",

    methods: {
        showWalletDetails(i: number) {
            if (this.showWallet[i])
                this.showWallet[i] = false;
            else
                this.showWallet[i] = true;
        },
        showEdit(i: number) {
            if (this.showEditor[i])
                this.showEditor[i] = false;
            else
                this.showEditor[i] = true;
        },
        
        editAmount(amount: number, wallet: any) {
            const walletService = new WalletService();
            walletService.editAmount(amount, wallet.id);
        },
    },
    setup() {
        const service = new UserService();
        const walletService = new WalletService();
        const user = service.getUser();
        const info = walletService.getInfo();
        const isLoading = ref<boolean>(true);
        const showWallet = ref<Array<boolean>>([]);
        const showEditor = ref<Array<boolean>>([]);
        const amount = 0;
        const { id } = useRoute().params;
        onMounted(async () => {
            service.fetchById(id);
            isLoading.value = false;
        });

       function deleteWallet(wallet: any) {
            const walletService = new WalletService();
            walletService.deleteWallet(wallet.id);
        }
        
        return {
            user,
            isLoading,
            showWallet,
            showEditor,
            amount,
            info,
            deleteWallet
        };
    },

});
</script>

<style></style>
