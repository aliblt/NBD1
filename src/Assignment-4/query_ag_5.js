printjson(
    db.people.aggregate(
        {
            $unwind: "$credit"
        },
        {
            $match: {
                sex: "Female",
                nationality: "Poland"
            }
        },
        {
            $group: {
                _id: "$credit.currency",
                "Average balance": { $avg: {$toDouble: "$credit.balance"} },
                "Total balance": { $sum: {$toDouble: "$credit.balance" } }
            }
        }
    ).toArray()
);