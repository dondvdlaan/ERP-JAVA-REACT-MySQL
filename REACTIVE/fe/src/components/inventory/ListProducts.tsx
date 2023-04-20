import AppBar from "@mui/material/AppBar";
import Box from "@mui/material/Box";
import Button from "@mui/material/Button";
import Card from "@mui/material/Card";
import CardActions from "@mui/material/CardActions";
import CardContent from "@mui/material/CardContent";
import CardMedia from "@mui/material/CardMedia";
import Container from "@mui/material/Container";
import Grid from "@mui/material/Grid";
import Stack from "@mui/material/Stack";
import { ThemeProvider } from "@mui/material/styles";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import { Product } from "../../types/Product";
import { Copyright } from "../../shared/Copyright";
import { Paper, styled } from "@mui/material";

const Item = styled(Paper)(({ theme }) => ({
  backgroundColor: theme.palette.mode === 'dark' ? '#1A2027' : '#fff',
  ...theme.typography.body2,
  padding: theme.spacing(1),
  textAlign: 'center',
  color: theme.palette.text.secondary,
}));


interface Props{
  products: Product[],
  onDelete: (id: string) => void,
  onCreate: () => void
}
/**
 * Component to list all products from Inventory
 */
export const ListProducts = (props: Props) => {

    return (
      <>
      <Card
          sx={{ height: '100%', display: 'flex', flexDirection: 'column' }}
        >
          <CardContent sx={{ flexGrow: 1 }}>
            <Typography gutterBottom variant="h5" component="h4" align="center">
              List products
            </Typography>
            <Grid container spacing={2}>
            {props.products.map(p =>

              <Grid key={p.prodID} item xs={12} md={6}>
                <Item>Id: {p.prodID} Name: {p.prodName} Price: {p.prodPrice}
                  <br /> 
                  <Button onClick={()=>props.onDelete(p.prodID)} size="small">Delete</Button>
                </Item>
              </Grid>
            
            )}  
            </Grid>
          </CardContent>
          <CardActions>
            <Button size="small">Ready</Button>
          </CardActions>
        </Card>            
        
    </>
        
    );
  }