printjson(
    db.people.mapReduce(
        function() {
            emit(this.sex, { weight: parseFloat(this.weight), height: parseFloat(this.height) });
        },
        function(k, v) {
            let weightList = v.map(x => x.weight);
            let heightList = v.map(x => x.height);
            let countH = heightList.length
            let countW = weightList.length
            return {
                weight: weightList.reduce((a, b) => a + b) / countW,
                height: heightList.reduce((a, b) => a + b)/ countH
            };
        },
        {
            out: { inline: 1 }
        }
    )
);