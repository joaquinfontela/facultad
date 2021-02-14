import React from 'react';
import './ButtonMenu.css'
import { MenuButton } from './MenuButton/MenuButton'


interface ButtonMenuProps {
    onClick: any
}

export class ButtonMenu extends React.Component<ButtonMenuProps> {

    constructor(props: any) {
        super(props);
    }

    render(): JSX.Element {
        return (
            <div className="buttonMenu">
                <MenuButton text="DISPONIBLES" onClick={() => this.props.onClick('available')} />
                <MenuButton text="RESTANTES" onClick={() => this.props.onClick('remaining')} />
                <MenuButton text="CREDITOS" onClick={() => this.props.onClick('credits')} />
                <MenuButton text="APROBADAS" onClick={() => this.props.onClick('passed')} />
                <MenuButton text="ACTUALIZAR" onClick={() => this.props.onClick('update')} />
                <MenuButton text="AYUDA" onClick={() => this.props.onClick('help')} />
            </div>
        );
    }
}