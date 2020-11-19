printjson(
    db.people.mapReduce(
        function() {
            emit(this.nationality, { weight: parseFloat(this.weight), height: parseFloat(this.height) });
        },
        function(k, v) {
            let BMI = v.map(x => 10000*x.weight/(x.height*x.height));
            let count = BMI.length
            return {
                MinimumBMI: BMI.reduce((a, b) => a < b?a:b),
                MaximumBMI: BMI.reduce((a, b) => a > b?a:b),
                AverageBMI: BMI.reduce((a,b) => a+b) / count,
            };
        },
        {
            out: { inline: 1 }
        }
    )
);