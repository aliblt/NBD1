printjson(
    db.people.aggregate(
        {
            $unwind: "$credit"
        },
        {
            $group: {
                _id: "$credit.currency",
                "Total balance": { $sum: { $toDouble: "$credit.balance" } }
            }
        })
        .toArray()
);
