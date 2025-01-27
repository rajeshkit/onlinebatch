import { Link, NavLink} from "react-router-dom";

function Header(){
    return (<div>
        <nav>
        <ul>
          <NavLink to="/">
            Home
          </NavLink>
          <Link to="/product">
            products
          </Link>
          <Link to="/service">
            services
          </Link>
          <Link to="/contactus">
            Contact us
          </Link>
        </ul>
      </nav>
    </div>)
}
export default Header;