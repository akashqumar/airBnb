import { Header } from './components/Header'
import { SearchBar } from './components/SearchBar'
import { ListingGrid } from './components/ListingGrid'

export function App() {
  return (
    <main className="container">
      <Header />
      <SearchBar />
      <ListingGrid />
    </main>
  )
}
