function fn() {
    var port = karate.properties['ItinaririesSearchAppIT.server.port'] || 7070;
    return {
        ItinaririesSearchAppUrl: 'http://127.0.0.1:' + port + '/api/flights/itineraries-search'
    };
}