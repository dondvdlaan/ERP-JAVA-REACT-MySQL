import Box from '@mui/material/Box';
import Container from '@mui/material/Container';
import Grid from '@mui/material/Grid';
import Typography from '@mui/material/Typography';

import React from 'react';
import { useApi } from '../../shared/API';
import { Product } from '../../types/Product';
import { Copyright } from '../../shared/Copyright';
import Create from './Create';
import { ListProducts } from './ListProducts';

/**
 * Component Inventory for overview of Create / Delete / List and Edit of products
 */
function Inventory() {

  // *** Constants and variables ***
  const [products, setProducts] = useApi<Product[]>("inventory","api/products/allProducts");

  // Wait till products arrive
  if(!products) return (<p>Loading Products...</p>)

  console.log("Producs: ", products);

  // *** Event handlers ***
  const onDelete = (id: String) => console.log("Delete ",{id});

  const onCreate = () => console.log("Create ");


  return (
  <>
    {/* Header */}
    <Container maxWidth="sm">
      <Box sx={{ my: 1 }} color="secondary.light" >
        <Typography 
        variant="h5" 
        component="h3" 
        gutterBottom 
        color="primary.light"
        align = "center"
        >
          Inventory Testing
        </Typography>
      </Box>
    </Container>
    {/* End Header */}

    <main>
      <Container  >
        <Grid container spacing={1}>
        <Grid item xs={12} sm={6} md={6}>
            <Create />
          </Grid>
          <Grid item xs={12} sm={6} md={6}>
            <Create />
          </Grid>
          <Grid item xs={12} sm={12} md={12}>
            <ListProducts products={products} onDelete={onDelete} onCreate={onCreate}  />
          </Grid>
        </Grid>
      </Container>        
    </main>
    {/* Footer */}
    <Box sx={{ bgcolor: 'background.paper', p: 1, my:1 }} component="footer">
      <Copyright />
    </Box>
    {/* End footer */}
  </>  
  );
}

export default Inventory;
