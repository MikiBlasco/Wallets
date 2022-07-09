interface Info {

    data?: {
        BTC?: {
            id?: number,
            symbol?: String,
            quote?: {
                USD?: {
                    price?: number,
                    percent_change_24h?: number,
                    market_cap?: number,

                }
            }
        }
    }

}

export default Info