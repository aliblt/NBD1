printjson(
    db.people.mapReduce(
        function()
        {
            this.credit.forEach(credit => emit(credit.currency, parseFloat(credit.balance)));
        },
        function(k,v)
        {
            return v.reduce((x, y) => x + y);
        },
        {
            out: {inline: 1}
        }
    )
);