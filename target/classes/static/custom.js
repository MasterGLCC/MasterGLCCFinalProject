
const loadAbsence = (docid, name) => {

    $.ajax({
        type: "GET",
        url: "/api/v1/doctorants/absence/" + docid,
        dataType: "json",
        success: function (response) {
            // Handle the successful response here
            // $("#spinner").hide();
            // $("#mychartContainer").show();

            console.log(response);
            const template = $("#chart-template").html();
            let html = '';
            response.map((absence, index) => {
                // console.log(index, absence);

                const rendered = Mustache.render(template, absence);
                console.log("rendered", rendered);
                html += rendered
                $("#mychartContainer").html(html);
                var ctx = document.getElementById('myPieChart' + absence.date).getContext('2d');
                const totalAbsence = absence.absences
                const totalPresence = absence.total - totalAbsence
                console.log(totalPresence, totalAbsence);
                var data = {
                    labels: ['Presence', 'Absence'],
                    datasets: [{
                        data: [totalPresence, totalAbsence], // Replace with your data values
                        backgroundColor: ['#5cb85c', '#d9534f'], // Replace with your desired colors
                    }],
                };
                new Chart(ctx, {
                    type: 'pie',
                    data: data,
                });
            })

            response.map((absence, index) => {
                // console.log(index, absence);


                var ctx = document.getElementById('myPieChart' + absence.date).getContext('2d');
                const totalAbsence = absence.absences
                const totalPresence = absence.total - totalAbsence
                console.log(totalPresence, totalAbsence);
                var data = {
                    labels: ['Presence', 'Absence'],
                    datasets: [{
                        data: [totalAbsence, totalPresence], // Replace with your data values
                        backgroundColor: ['#5cb85c', '#d9534f'], // Replace with your desired colors
                    }],
                };
                new Chart(ctx, {
                    type: 'pie',
                    data: data,
                });
            })

            // Define the data for the pie chart

        },
        error: function (error) {
            // Handle any errors here
            console.error("Error:", error);
        }
    });

}

const loadAvancement = (docid) => {
    $.ajax({
        type: "GET",
        url: "/api/v1/doctorants/avancement/" + docid,
        dataType: "json",
        success: function (response) {
            console.log(response);
            const template = $("#card-template").html();
            let html = '';
            response.map(item => {
                const rendered = Mustache.render(template, item);
                console.log("rendered", rendered);
                html += rendered
                $("#cardsContainer").html(html);
            })

            var months = response.map(item => item.date);
            var evs = response.map(item => item.evaluation);
            console.log("evs", evs);

            var ctx = document.getElementById('barChart').getContext('2d');

            var myBarChart = new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: months,
                    datasets: [{
                        label: "evaluation",

                        data: evs,
                        backgroundColor: [
                            '#eeecfd'
                        ],
                        borderColor: [
                            '#673AB7'
                        ],
                        borderWidth: 1,


                    }]
                },
                options: {
                    scales: {
                        y: {
                            beginAtZero: true
                        }
                    },
                    plugins: {
                        tooltip: {
                            callbacks: {
                                title: function (context) {
                                    var dataIndex = context.dataIndex;
                                    return response[dataIndex]?.title;
                                },
                                label: function (context) {
                                    // You can access the index using tooltipItem.index
                                    var dataIndex = context.dataIndex;

                                    // Your label logic here
                                    return response[dataIndex]?.title;
                                },
                                afterLabel: function (context) {
                                    // You can access the index using tooltipItem.index
                                    var dataIndex = context.dataIndex;

                                    // Your label logic here
                                    return 'Note: ' + response[dataIndex]?.evaluation;
                                },
                            }
                        }
                    }
                },

            });


            console.log(response);


        }
    })
}


const loadPublication = (docid) => {
    $.ajax({
        type: "GET",
        url: "/api/v1/doctorants/publications/" + docid,
        dataType: "json",
        success: function (response) {
            renderPublications(response)
        }
    })
}
const showResume = (resume) => {
    $("#resume").html(resume)
}

const renderPublications = (data) => {

    const template = $('#publication-template').html();

    const rendered = Mustache.render(template, { pubs: data });

    $('#tbody').html(rendered);
}

