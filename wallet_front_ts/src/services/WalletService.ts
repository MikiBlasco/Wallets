import Wallet from "../interfaces/Wallet";
import AddWalletDTO from "../models/AddWalletDTO";
import { Ref, ref } from "vue";

export class WalletService {

    private wallet: Ref<Wallet>
  
  
    constructor() {     
      this.wallet = ref<Wallet>({})
    
    }

    getWallet(): Ref<Wallet>{
        return this.wallet;
    }

    async addWallet(wallet: AddWalletDTO): Promise<void>{
        const requestOptions = {
            method: "POST",
            headers: { "Content-Type": "application/json"  },
            body: JSON.stringify(wallet)
        };
        const response = await fetch(`http://localhost:4000/add-wallet`, requestOptions);
        const data = await response.json();
        wallet = data.id;
    }
}

