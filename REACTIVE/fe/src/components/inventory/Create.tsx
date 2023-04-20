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
import { Copyright } from "../../shared/Copyright";


export default function Create() {

    return (
      <>
        <Card
          sx={{ height: '100%', display: 'flex', flexDirection: 'column' }}
        >
          <CardContent sx={{ flexGrow: 1 }}>
            <Typography gutterBottom variant="h5" component="h4" align="center">
              Create
            </Typography>
            <Typography>
                        This is a media card. You can use this section to describe the
                        content.
            </Typography>
          </CardContent>
          <CardActions>
            <Button size="small">Ready</Button>
          </CardActions>
        </Card>
                
        
    </>
        
    );
  }