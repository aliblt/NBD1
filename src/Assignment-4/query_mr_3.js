printjson(
    db.people.mapReduce(
        function()
        {
            emit(this.job, null)
        },
        function(k,v)
        {},
        {
            out: {inline: 1}
        }
    )
);