// $(document).ready(function() {
//
//     var apiKey = "85b1beaf";
//
//     $('#form').submit(function(e) {
//         e.preventDefault();
//
//         var movie = $('#search').val();
//         var url = "http://www.omdbapi.com/?apikey=" + apiKey +"&s=" + movie;
//         var restHTML = `
//                 	<div class="container text-center">
//                 		<div class="row">
//                 	`;
//
//         $.get(url, {
//         }).done(function(data) {
//             // console.log(data);
//             console.log(data.Search);
//             var movies = data.Search;
//
//             $('#result').empty();
//             $.each(movies, function(index, movie) {
//                 var poster = movie.Poster;
//                 var title = movie.Title;
//                 var year = movie.Year;
//                 var imdbID = movie.imdbID;
//
//                 restHTML += `
// 								<div class="col-sm-12 col-md-6 mb-4">
// 									<a href="#"><img onclick="selectMovie('${imdbID}')" class="img-thumbnail" src="${poster}" style="width: 310px; height:445px;"></a>
// 									<h4>${title}</h4>
// 									<p>${year}</p>
// 								</div>
// 						`
//             });
//             restHTML += `</div> </div>`;
//             $('#result').append(restHTML);
//         }).fail(function(errors) {
//             console.error(errors);
//         });
//     })
//
//     function selectMovie(id) {
//         sessionStorage.setItem('movieId', id);
//         window.location = 'show.html';
//         return false;
//     }
//
// })