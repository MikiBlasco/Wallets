interface User {

    id?: number
    name?: string
    mail?: string
    password?: string
    walletList?: [
        {
            id?: number
            currency_name?: string
            currency_amount?: number
        }
    ];

}

export default User