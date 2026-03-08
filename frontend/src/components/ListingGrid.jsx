const mockListings = [
  { id: 1, title: 'Beachfront Villa', location: 'Goa, India', price: '$220 night', rating: '4.92' },
  { id: 2, title: 'Mountain Cabin', location: 'Manali, India', price: '$120 night', rating: '4.87' },
  { id: 3, title: 'City Loft', location: 'Bangalore, India', price: '$95 night', rating: '4.81' }
]

export function ListingGrid() {
  return (
    <section>
      <h2>Popular homes</h2>
      <div className="grid">
        {mockListings.map((listing) => (
          <article key={listing.id} className="card">
            <div className="image" />
            <h3>{listing.title}</h3>
            <p>{listing.location}</p>
            <p>{listing.price}</p>
            <span>★ {listing.rating}</span>
          </article>
        ))}
      </div>
    </section>
  )
}
