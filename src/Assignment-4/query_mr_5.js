printjson(
    db.people.mapReduce(
        function()
        {
            if( this.nationality === "Poland" && this.sex === "Female")
                this.credit.forEach(credit => emit(credit.currency, parseFloat(credit.balance)));
        },
        function(k,v)
        {
            return{
                AverageBalance: v.reduce((x, y) => x + y) / v.length,
                TotalBalance: v.reduce((x, y) => x + y)
            };
        },
        {
            out: { inline: 1 }
        }
    )
);