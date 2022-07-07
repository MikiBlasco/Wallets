import Wallet from "../interfaces/Wallet";
import Info from "../interfaces/Info";
import AddWalletDTO from "../models/AddWalletDTO";
import { Ref, ref } from "vue";

export class WalletService {

    private wallet: Ref<Wallet>
    private wallets: Ref<Array<Wallet>>
    private info: Ref<Info>
  
  
    constructor() {     
      this.wallet = ref<Wallet>({}),
      this.wallets = ref<Array<Wallet>>([]),
      this.info = ref<Info>({})
    
    }

    getWallet(): Ref<Wallet>{
        return this.wallet;
    }

    getWallets(): Ref<Array<Wallet>>{
        return this.wallets;
    }

    getInfo(): Ref<Info>{
        return this.info;
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

    async deleteWallet(id: any): Promise<void>{

        try{
            const requestOptions = {
                method: "DELETE",
                headers: { "Content-Type": "application/json"  },
            };
        const url = `http://localhost:4000/delete-wallet/${id}`
        const response = await fetch(url, requestOptions)
        const json  = await response.json()
        this.wallet.value = await json

        } catch (error) {

            console.log(error)
        }
       

    }

    async editAmount(amount: number, id:number): Promise<void>{

        try{
            const requestOptions = {
                method: "PATCH",
                headers: { "Content-Type": "application/json"  },
            };
        const url = `http://localhost:4000/modify-amount/${id}?amount=${amount}`
        const response = await fetch(url, requestOptions)
        const json  = await response.json()
        this.wallet.value = await json

        } catch (error) {

            console.log(error)
        }
       

    }

    async getUsdPrice(): Promise<void> {

        try{
        const url = `https://pro-api.coinmarketcap.com/v1/cryptocurrency/quotes/latest?symbol=BTC`
        const response = await fetch(url, {
            method: "GET",
            mode: 'no-cors',
            headers: { 
            "Content-Type": "application/json",
            "X-CMC_PRO_API_KEY": "86e0fd37-8493-4716-90de-ddab8f5299ac",
            'Access-Control-Allow-Origin' : '*' },           
            
        })
        const json  = await response.json()
        this.info.value = await json
        console.log(this.info.value)

        } catch (error) {

            console.log("errrorrrrrrrrrrrrrrrrrrrrr" + error)
        }
       

    }




}

