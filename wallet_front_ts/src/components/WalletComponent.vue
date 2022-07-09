<template>

  <div>
    <div v-if="!isLoading">
      {{ user.name }} wallets

      <div
        class="walletCard"
        v-for="(wallet, index) in user.walletList"
        :key="wallet.id"
      >
       <!-- <WalletCardComponent :wallet="wallet" ></WalletCardComponent> -->
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
                <button class="button3" v-on:click="editAmount(amount, wallet)" 
                style="background-color: black; color:white">
                save
                </button>


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
import { onMounted, ref } from "vue";
import { useRoute } from "vue-router";
import WalletCardComponent from "./WalletCardComponent.vue";


export default {
    name: "WalletComponent",
    components: { WalletCardComponent },
    
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
            walletService.deleteWallet(wallet.id).then(() => {
                service.fetchById(id);
            });
        }

        function showWalletDetails(i: number) {
            if (showWallet.value[i])
                showWallet.value[i] = false;
            else
                showWallet.value[i] = true;
        }

        function showEdit(i: number) {
            if (showEditor.value[i])
                showEditor.value[i] = false;
            else
                showEditor.value[i] = true;
        }

        function editAmount(amount: number, wallet: any) {
            walletService.editAmount(amount, wallet.id).then(() => {
                service.fetchById(id);
            });
        }

        return {
            user,
            isLoading,
            showWallet,
            showEditor,
            amount,
            info,
            deleteWallet,
            showWalletDetails,
            showEdit,
            editAmount
        };
    },
    
};
</script>

<style></style>
